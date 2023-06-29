package br.edu.iff.bsi.Pizzaria.entities;

public class Cliente {
	private float saldoDisponivel;

    public Cliente(String id, String nome, String email, String cpf, String password, float saldoDisponivel) {
  
    	super();
    	
    	
        this.saldoDisponivel = saldoDisponivel;
    }
    

    public float getSaldoDisponivel() {
        return saldoDisponivel;
    }

    public void setSaldoDisponivel(float saldoDisponivel) {
        this.saldoDisponivel = saldoDisponivel;
    }

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getcpf() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
