package br.com.hoepers.webtest.utils;

/**
 * Classe utilizada para definir padr�o de constantes ao sistema.
 * @date   12.07.06
 * @author IMMEDIATE - Cassio Dias
 */
public class ConstantesUtil {
	public static String ACAO_NOVO                  = "NOVO";
	public static String ACAO_LISTAR                = "LISTAR";
	public static String ACAO_EDITAR                = "EDITAR";
	public static String ACAO_DELETAR               = "DELETAR";
	public static String ACAO_EDITANDO              = "EDITANDO";
	public static String ACAO_EDITANDO_BILHETE_AEREO= "EDITANDO_BILHETE_AEREO";
	public static String ACAO_GRAVAR_DADOS_BASICOS  = "GRAVAR_DADOS_BASICOS";
	public static String ACAO_ALTERAR_DADOS_BASICOS = "ALTERAR_DADOS_BASICOS";	
	public static String ACAO_RESERVAR_PASSAGEM     = "RESERVAR_PASSAGEM";
	public static String ACAO_RESERVAR_HOTEL        = "RESERVAR_HOTEL";
	public static String ACAO_DELETAR_HOTEL         = "DELETAR_HOTEL";
	public static String ACAO_DELETAR_PASSAGEM      = "DELETAR_PASSAGEM";
	public static String ACAO_DELETAR_CENTRO_CUSTO  = "DELETAR_CENTRO_CUSTO";
	public static String ACAO_RELOAD                = "RELOAD";
	public static String ACAO_LISTA_DESTINO_REGRA   = "LISTA_DESTINO_REGRA";
	public static String ACAO_LISTA_UNIDADE_ORGANIZACIONAL = "LISTA_UNIDADE_ORGANIZACIONAL";
	public static String ACAO_START_WF                     = "START_WF";
	public static String ACAO_START_WF_PREVISAO            = "START_WF_PREVISAO";
	public static String ACAO_CALCULA_DESPESAS             = "CALCULA_DESPESAS";
	public static String ACAO_CALCULA_DEVOLUCAO            = "CALCULA_DEVOLUCAO";
	public static String ACAO_SOMA_CLICK                   = "SOMA_CLICK";
	public static String ACAO_LISTA_RATEIO                 = "LISTA_RATEIO";
	public static String ACAO_DELETAR_DESPESA_RDV          = "DELETAR_DESPESA_RDV";
	public static String ACAO_EXCLUIR_TRECHO               = "EXCLUIR_TRECHO";	
	public static String ACAO_ALTERA_CONTA_CONTABIL_SEGURO = "ALTERA_CONTA_CONTABIL_SEGURO";
	public static String ACAO_DELETAR_SEGURO_COTACAO       = "DELETAR_SEGURO_COTACAO";
	public static String ACAO_DELETAR_SEGURO_CONTATO       = "DELETAR_SEGURO_CONTATO";
	public static String ACAO_RESERVAR_SEGURO_COTACAO      = "RESERVAR_SEGURO_COTACAO";
	public static String ACAO_DELETAR_ARQUIVO_ANEXO        = "DELETAR_ARQUIVO_ANEXO";
	public static String ACAO_UPLOAD_ANEXO_SDV             = "UPLOAD_SDV";
	public static String FLAG_START_WF_EXPEDICAO           = "EXPEDICAO";
	public static String ACAO_DELETAR_END_DEST_MALOTE_EXP  = "DELETAR_END_DEST_MALOTE_EXP";
	public static String MALOTE_EXP_ALTERACAO_ITINERARIO   = "AI";
	public static String ACAO_GRAVAR_ENDERECO_FILHO        = "GRAVAR_ENDERECO_FILHO";
	public static String ACAO_GRAVAR_PLACA_PATRIMONIAL     = "GRAVAR_PLACA_PATRIMONIAL";
	public static String ACAO_DELETAR_PLACA_PATRIMONIAL    = "DELETAR_PLACA_PATRIMONIAL";
	public static String ACAO_DELETAR_END_DEST_BENS_MATERIAIS = "DELETAR_END_DEST_BENS_MATERIAIS";
	public static String ACAO_CALCULAR_FRETE               = "CALCULAR_FRETE";
	public static String ACAO_CALCULAR_FRETE_OUTRO_SERVICO = "CALCULAR_FRETE_OUTRO_SERVICO";
	public static String ACAO_CALCULAR_VALOR_PRAZO         = "CALCULAR_VALOR_PRAZO";
	public static String ACAO_CALCULAR_SERVICO_CORREIO     = "CALCULAR_SERVICO_CORREIO";
	public static String ACAO_APROVAR                      = "S";
	public static String ACAO_REPROVAR                     = "N";
	public static String ACAO_CRIAR_COPIA_TELE_ENTREGA     = "CRIAR_COPIA_TELE_ENTREGA";
	public static String ACAO_CRIAR_COPIA_SERVICO_TRANSPORTADORA = "CRIAR_COPIA_SERVICO_TRANSPORTADORA";
	public static String ACAO_CALCULAR_VALOR		       = "CALCULA_VALOR";
	public static String ACAO_DELETAR_SERVICO		       = "DELETAR_SERVICO";
	public static String ACAO_SIMULAR_SERVICO			   = "SIMULAR_SERVICO";
	
	//> CONSTANTE PARA CONTROLE DE VISUALIZACAO DE TELA.
	public static Integer VISUALIZACAO_AGENCIA                                              = new Integer(1);
	public static Integer VISUALIZACAO_EMITENTE_RETORNO_AGENCIA                             = new Integer(2);
	public static Integer SOMENTE_VISUALIZACAO                                              = new Integer(3);
	public static Integer VISUALIZACAO_EMITENTE_RECEBE_GESTOR                               = new Integer(4);
	public static Integer VISUALIZACAO_EMITENTE_APOS_GRAVAR_DADOS_BASICOS_VIAGEM_EM_GRUPO   = new Integer(5);
	public static Integer VISUALIZACAO_EMITENTE_APOS_GRAVAR_DADOS_BASICOS_VIAGEM_INDIVIDUAL = new Integer(6);
	public static Integer VISUALIZACAO_GRAVAR_PREVISAO_DESPESA                              = new Integer(7);
	public static Integer VISUALIZACAO_GRAVAR_PRESTACAO_DE_CONTAS                           = new Integer(8);
	public static Integer VISUALIZACAO_EMITENTE_APOS_START_WF                               = new Integer(9);
	public static Integer VISUALIZACAO_EMITENTE_RECEBE_GESTOR_PRESTACAO_DE_CONTAS           = new Integer(10);
	public static Integer VISUALIZACAO_AGENCIA_INSERE_NUMERO_BILHETE                        = new Integer(11);
	public static Integer VISUALIZACAO_GRAVAR_COMPLEMENTO_DESPESA                           = new Integer(12);
	public static Integer VISUALIZACAO_GESTOR                                               = new Integer(13);
	public static Integer VISUALIZACAO_TELA_FIND_INDIVIDUAL                                 = new Integer(14);
	public static Integer VISUALIZACAO_TELA_FIND_GRUPO                                      = new Integer(15);
	public static Integer VISUALIZACAO_GESAD_SELECIONA_SEGURO                               = new Integer(16);
	public static Integer VISUALIZACAO_AGENCIA_INSERE_ANEXOS                                = new Integer(17);
	
	
	//***
	public static double VALOR_MAXIMO_EM_TESOURARIA = 300.0d;
}
