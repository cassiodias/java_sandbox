package br.com.hoepers.webtest.utils;

public class MultisatParametros {

	public int getFrota(){
		return FROTA;
	}
	public int getAgregado(){
		return AGREGADO;
	}
	public int getRh(){
		return RH;
	}
	public int getAutonomo(){
		return AUTONOMO;
	}
	public String getPesquisaNaoEncontrada(){
		return PESQUISA_NAO_ENCONTRADA;
	}
	public String getPesquisaAberta(){
		return PESQUISA_ABERTA;
	}
	public String getPesquisaInsuficiente(){
		return PESQUISA_INSUFICIENTE;
	}
	public String getCoberturaSeguroAutorizada(){
		return COBERTURA_DE_SEGURO_AUTORIZADA;
	}
	public String getCoberturaSeguroVencida(){
		return COBERTURA_DE_SEGURO_VENCIDA;
	}
	
	public static final String PENDENTE = "1";
	public static final String EM_ANALISE = "2";
	public static final String ECERRADA = "3";
	public static final String ENVIADO_FAX = "4";
	public static final String CONFIRMADO_FAX = "5";
		
	 /** Tipo de pesquisa - frota própria*/
    public static final int FROTA = 1;

    /** Tipo de pesquisa - agregado*/
    public static final int AGREGADO = 2;

    /** Tipo de pesquisa - recursos humanos*/
    public static final int RH = 3;

    /** Tipo de pesquisa - autônomo*/
    public static final int AUTONOMO = 4;

    /** Tipo de retorno - Quando a pesquisa não foi encontrada*/
    public static final String PESQUISA_NAO_ENCONTRADA = "PESQUISA_NAO_ENCONTRADA";

    /** Tipo de retorno - Quando a pesquisa está com situação ABERTA*/
    public static final String PESQUISA_ABERTA = "PESQUISA_ABERTA";

    /** Tipo de retorno - Quando os dados da pesquisa não foram suficientes*/
    public static final String PESQUISA_INSUFICIENTE = "PESQUISA_INSUFICIENTE";

    /** Tipo de retorno - Quando a pesquisa foi autorizada*/
    public static final String COBERTURA_DE_SEGURO_AUTORIZADA = "COBERTURA_DE_SEGURO_AUTORIZADA";

    /** Tipo de retorno - Quando a pesquisa etá vencida*/
    public static final String COBERTURA_DE_SEGURO_VENCIDA = "COBERTURA_DE_SEGURO_VENCIDA";

}
