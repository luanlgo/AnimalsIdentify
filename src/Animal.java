/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalsIdentify;

/**
 *
 * @author Luan Gomes
 */
public class Animal {
    
    private int identificacao;
    private BalancaList historicos;
    
    public Animal() {
        this.historicos = new BalancaList();
    }
    
    public int getIdentificacao() {
        return identificacao;
    }

    public Animal setIdentificacao(int identificacao) {
        this.identificacao = identificacao;
        return this;
    }

    public BalancaList getHistoricos() {
        return this.historicos;
    }

    public BalancaList setHistoricos(BalancaList historicos) {
        this.historicos = historicos;
        return this.historicos;
    }
    
    public void addHistorico(Historico historico) {
        this.historicos.getHistoricos().add(historico);
    }
    
}
