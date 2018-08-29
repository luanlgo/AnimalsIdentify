package trabalho_04_09;

import java.util.ArrayList;

/**
 *
 * @author Luan Gomes
 */
public class BalancaList {
    
    private ArrayList<Historico> historicos;
    
    public BalancaList() {
        this.historicos = new ArrayList<>();
    }
    
    public void addItem(Historico historico) {
        this.historicos.add(historico);
    }

    public ArrayList<Historico> getHistoricos() {
        return historicos;
    }
    
}
