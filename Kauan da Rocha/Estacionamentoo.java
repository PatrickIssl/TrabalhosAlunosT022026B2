package fag;

import java.util.Scanner;

public class Estacionamentoo 
{
	String placa;
	String modelo;
	int minutosestacionado;
	float valorpago;
	
	
	
	public Estacionamentoo(String placa, String modelo) {
		this.placa = placa;
		this.modelo = modelo;
		this.minutosestacionado = 0;
		this.valorpago = 0;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public float getMinutosestacionado() {
		return minutosestacionado;
	}
	public void setMinutosestacionado(int minutosestacionado) {
		this.minutosestacionado = minutosestacionado;
	}
	public float getValorpago() {
		return valorpago;
	}
	public void setValorpago(float valorpago) {
		this.valorpago = valorpago;
	}
	
	
	public void adicionartempo(int tempo) 
	{
		
		if(tempo <0) 
		{
			System.out.println("o tempo adicionado nao pode ser negativo");
		}
		else 
		{
			this.minutosestacionado+=tempo;
		}
		
		
		
		
	}
	
	public float Valorpagar() 
	{
		float valor;
		int minutosextra;
		if(minutosestacionado <= 30) 
		{
			valor=5f;	
		}
		else 
		{
			minutosextra= minutosestacionado-30;
			valor=5f+minutosextra*0.10f;
		}
		
		this.valorpago = Math.min(valor,30f);
		return this.valorpago;
	}
	
	public void exibirResumo() {
        System.out.println("Placa: " + this.placa);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Tempo estacionado: " + this.minutosestacionado + " minutos");
        System.out.printf( "Valor pago: R$ %.2f%n", this.valorpago);
    }
}


