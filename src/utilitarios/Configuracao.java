package utilitarios;

import java.io.FileNotFoundException;

import com.google.gson.Gson;

import mainProgram.MainProgram;

public class Configuracao {
	
	private int initialShootingDelay; 
	private int invaderShootingCooldownPeriod;
	private int invaderNextLineHeight;
	private int invaderRowQtd;
	private int invaderColumnQtd;
	private double invaderShipConstantSpeedUp;
	
	private int shipShootingCooldownTime;
	
	public int getInitialShootingDelay() {
		return initialShootingDelay;
	}
	public void setInitialShootingDelay(int initialShootingDelay) {
		this.initialShootingDelay = initialShootingDelay;
	}
	public int getInvaderShootingCooldownPeriod() {
		return invaderShootingCooldownPeriod;
	}
	public void setInvaderShootingCooldownPeriod(int invaderShootingCooldownPeriod) {
		this.invaderShootingCooldownPeriod = invaderShootingCooldownPeriod;
	}
	public int getInvaderNextLineHeight() {
		return invaderNextLineHeight;
	}
	public void setInvaderNextLineHeight(int invaderNextLineHeight) {
		this.invaderNextLineHeight = invaderNextLineHeight;
	}
	public int getInvaderRowQtd() {
		return invaderRowQtd;
	}
	public void setInvaderRowQtd(int invaderRowQtd) {
		this.invaderRowQtd = invaderRowQtd;
	}
	public int getInvaderColumnQtd() {
		return invaderColumnQtd;
	}
	public void setInvaderColumnQtd(int invaderColumnQtd) {
		this.invaderColumnQtd = invaderColumnQtd;
	}
	
	/**
	 * Inicializar configuração
	 * @param initialShootingDelay
	 * @param invaderShootingCooldownPeriod
	 * @param invaderNextLineHeight
	 * @param invaderRowQtd
	 * @param invaderColumnQtd
	 */
	public Configuracao(int initialShootingDelay, int invaderShootingCooldownPeriod, int invaderNextLineHeight, int invaderRowQtd, int invaderColumnQtd, int shipShootingCooldownTime, double invaderShipConstantSpeedUp) {
		setInitialShootingDelay(initialShootingDelay);
		setInvaderShootingCooldownPeriod(invaderShootingCooldownPeriod);
		setInvaderNextLineHeight(invaderNextLineHeight);
		setInvaderRowQtd(invaderRowQtd);
		setInvaderColumnQtd(invaderColumnQtd);
		setShipShootingCooldownTime(shipShootingCooldownTime);
		setInvaderShipConstantSpeedUp(invaderShipConstantSpeedUp);
	}
	
	/**
	 * Configuração padrão.
	 * @return
	 */
	public static Configuracao getDefault(){
		Configuracao c = new Configuracao(250, 40, 50, 5, 7, 30, 0.001);
		return c;
	}
	
	/**
	 * Inicializar configuração a partir de arquivo.
	 * Se o arquivo não existir, será utilizado configurações padrões.
	 */
	public static Configuracao loadFromConfigFile(){
		Configuracao configuracao = null;
		
		//Gson
		Gson g = new Gson();
		
		//Ler arquivo de texto, com a configuração armazenada em Json
		String txtJson = null;
		try {
			txtJson = TextReader.readTextFile(MainProgram.CONFIG_FILE);
			configuracao = g.fromJson(txtJson, Configuracao.class);
		} catch (FileNotFoundException fe) {
			//Se não encontrar o arquivo, carregar configuração padrão.
			configuracao = getDefault();
			txtJson = g.toJson(configuracao);
			//Gravar no arquivo
			try {
				TextWriter.writeTextToFile(MainProgram.CONFIG_FILE, txtJson);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			//Outro erro
			e.printStackTrace();
		}
		
		System.out.println("Json arq.: " + txtJson);
		System.out.println("Json def.: " + g.toJson(configuracao));
		
		return configuracao;
	}
	public int getShipShootingCooldownTime() {
		return shipShootingCooldownTime;
	}
	public void setShipShootingCooldownTime(int shipShootingCooldownTime) {
		this.shipShootingCooldownTime = shipShootingCooldownTime;
	}
	public double getInvaderShipConstantSpeedUp() {
		return invaderShipConstantSpeedUp;
	}
	public void setInvaderShipConstantSpeedUp(double invaderShipConstantSpeedUp) {
		this.invaderShipConstantSpeedUp = invaderShipConstantSpeedUp;
	}
}
