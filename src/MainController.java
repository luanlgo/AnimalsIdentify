package AnimalsIdentify;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;

/**
 *
 * @author Luan Gomes
 */
public class MainController {
    
    private AnimalRepository animais;
    private String thisLine = "";
    private String currentDateFile = "";
    private File contextFile = null;
    
    public MainController() {
        this.animais = new AnimalRepository();
    }
    
    //Substituido pela view
    /*public static void main (String[] arrgs) {
        MainController util = new MainController();
        File contextFile = util.selectFile();
        
        if (contextFile != null) {
            util.feedingAnimals(contextFile);
        } else 
            System.err.println("Arquivo não selecionado.");
        
    }*/
    
    public void feedingAnimals(File contextFile) {
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(contextFile));
            
            while ((this.thisLine = entrada.readLine()) != null) {
                this.feedingAnimal();
            }
        } catch (Exception e) {
        }
    }
    
    private void feedingAnimal() {
        Historico historico = new Historico();
        try {
            //Tratando a primeira linha de data
            historico.setData(thisLine);
            this.currentDateFile = thisLine;
        } catch (Exception e) {
            String[] values = thisLine.split(",");
            Animal contextAnimal = getContextAnimal(Integer.parseInt(values[0]));
            try {
                historico.setData(this.currentDateFile);
            } catch (ParseException ex) {}
            historico.setPeso(Double.parseDouble(values[1]));
            historico.setAltura(Short.parseShort(values[2]));
            historico.setTemeratura(Double.parseDouble(values[3]));
            if (contextAnimal == null) {
                //Animal n cadastrado
                Animal animal = new Animal();
                animal.setIdentificacao(Integer.parseInt(values[0]));
                animal.getHistoricos().addItem(historico);
                this.animais.addAnimal(animal);
            } else {
                //Animal existente
                contextAnimal.getHistoricos().addItem(historico);
            }
            
        }
    }
    
    public File selectFile() {
        JFileChooser jfc = new JFileChooser();
        //Limitando apenas arquivos
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        //Pegando status de selecao
        int StatusVal = jfc.showOpenDialog(null);
        File file = null;
        //Testa se foi clicado em ok
        if (StatusVal == JFileChooser.APPROVE_OPTION) {
            file = jfc.getSelectedFile();
        }
        
        return file;
    }
    
    public DefaultListModel<String> getDefaultListModel(int identificador){
        DefaultListModel<String> listAnimal = new DefaultListModel<>();
        for (Animal animal : this.animais.getAnimais()) {
            if (intToString(animal.getIdentificacao()).startsWith(intToString(identificador)))
                listAnimal.addElement(intToString(animal.getIdentificacao()));
            
        }
        return listAnimal;
    }
    
    public DefaultListModel<String> getEmptyListModel() {
        DefaultListModel<String> emptyModel = new DefaultListModel<>();
        emptyModel.addElement("Identificador não encontrado :C");
        return emptyModel;
    }

    public File getContextFile() {
        return contextFile;
    }

    public void setContextFile(File contextFile) {
        this.contextFile = contextFile;
    }
    
    public Animal getContextAnimal(int identificado) {
        return this.animais.getIdentifyAnimal(identificado);
    }

    public AnimalRepository getAnimais() {
        return animais;
    }
    
    public String intToString(int val){
        return val+"";
    }
    
}
