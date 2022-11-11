import java.io.Serializable;

public class Data implements Serializable
{
    private int dia, mes, ano;

    private boolean bissexto (int ano)
    {
        if (ano%400==0)
            return true;

        if (ano%4==0 && ano%100!=0)
            return true;

        return false;
    }

    private boolean valida (int dia, int mes, int ano)
    {
        if (dia<1 || dia>31)
            return false;

        if (mes<1 || mes>12)
            return false;

        if ((mes==4 || mes==6 || mes==9 || mes==11) && dia>30)
            return false;

        if (dia>29 && mes==2)
            return false;

        if (dia>28 && mes==2 && !bissexto(ano))
            return false;

        return true;
    }

    public Data (int dia, int mes, int ano) throws Exception
    {
        if (!valida(dia,mes,ano))
            throw new Exception ("Data invalida");

        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public void setDia (int dia) throws Exception
    {
        if (!valida(dia,this.mes,this.ano))
            throw new Exception ("Data invalida");

        this.dia=dia;
    }

    public void setMes (int mes) throws Exception
    {
        if (!valida(this.dia,mes,this.ano))
            throw new Exception ("Data invalida");

        this.mes=mes;
    }

    public void setAno (int ano) throws Exception
    {
        if (!valida(this.dia,this.mes,ano))
            throw new Exception ("Data invalida");

        this.ano=ano;
    }

    public int getDia ()
    {
        return this.dia;
    }

    public int getMes ()
    {
        return this.mes;
    }

    public int getAno ()
    {
        return this.ano;
    }

    // solucao conservadora, pois nao crio data sem saber que � valida
    // solucao "gastona", pois valida 2 vezes, para fazer new e no contrutor quando ja fez new
    // � importante ressaltar que poder�amos ter adotado a abordagem ousada adotada no proximo
    // m�todo para fazer esse metodo; fizemos cada um com uma abordagem diferente apenas para
    // ilustrar essa abordagens.
    public Data diaSeguinte ()
    {
        Data ret=null;

        try
        {
            if (valida(this.dia+1,this.mes,this.ano))
                ret = new Data (this.dia+1,this.mes,this.ano);
            else
            if (valida(1,this.mes+1,this.ano))
                ret = new Data (1,this.mes+1,this.ano);
            else
                ret = new Data (1,1,this.ano+1);
        }
        catch (Exception erro)
        {} // sei que nao vai dar erro

        return ret;
    }

    // solucao ousada, pois vai tentando criar datas que talvez estejam erradas e
    // no tratamento das excecoes, faz novas tentativas que tambem podem estar erradas
    // solucao economica, pois nao valido antes de criar new Data; confio na excecao
    // que o new Data me der
    // � importante ressaltar que poder�amos ter adotado a abordagem conservadora adotada no
    // m�todo anterior para fazer esse metodo; fizemos cada um com uma abordagem diferente
    // apenas para ilustrar essa abordagens.
    public Data diaAnterior ()
    {
        Data ret = null;

        try {
            ret = new Data (this.dia-1,this.mes,this.ano);
        }
        catch (Exception a) {
            try {
                ret = new Data (31,this.mes-1,this.ano);
            }
            catch (Exception b) {
                try {
                    ret = new Data (30,this.mes-1,this.ano);
                }
                catch (Exception c) {
                    try {
                        ret = new Data (29,this.mes-1,this.ano);
                    }
                    catch (Exception d) {
                        try {
                            ret = new Data (28,this.mes-1,this.ano);
                        }
                        catch (Exception e) {
                            try {
                                ret = new Data (31,12,this.ano-1);
                            }
                            catch (Exception f)
                            {} // sei que nao vai dar erro
                        }
                    }
                }
            }
        }
        return ret;
    }

    // 1 dos 3 metodos obrigatorios SEMPRE
    public String toString ()
    {
        return (this.dia<10?"0":"")+
                this.dia+
                "/"+
                (this.mes<10?"0":"")+
                this.mes+
                "/"+
                (this.ano<0?-this.ano:this.ano)+
                (this.ano<0?"AC":"");
    }

    // 1 dos 3 metodos obrigatorios SEMPRE
    // serve para comparar this com obj
    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        //if (!(obj instanceof Data))
        //if (obj .getClass() != class)
        if (this.getClass() != obj.getClass())
            return false;

        //if (this.dia != ((Data)obj).dia ||
        //    this.mes != ((Data)obj).mes ||
        //    this.ano != ((Data)obj).ano)
        //    return false;
        Data data = (Data)obj;
        if (this.dia != dia ||
                this.mes != mes ||
                this.ano != ano)
            return false;

        return true;
    }
}
