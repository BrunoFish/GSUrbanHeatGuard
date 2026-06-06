import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegiaoUrbana {
    private int idRegiao;
    private String nomeLocal;
    private int raioMetros;
    private LocalDate dataImplantacao;
    private List<PontoPoligono> pontos; // Relacionamento 1:N

    public RegiaoUrbana() {
        this.pontos = new ArrayList<>();
    }

    public RegiaoUrbana(int idRegiao, String nomeLocal, int raioMetros, LocalDate dataImplantacao) {
        this.idRegiao = idRegiao;
        this.nomeLocal = nomeLocal;
        this.raioMetros = raioMetros;
        this.dataImplantacao = dataImplantacao;
        this.pontos = new ArrayList<>();
    }

    public int getIdRegiao() { return idRegiao; }
    public void setIdRegiao(int idRegiao) { this.idRegiao = idRegiao; }
    public String getNomeLocal() { return nomeLocal; }
    public void setNomeLocal(String nomeLocal) { this.nomeLocal = nomeLocal; }
    public int getRaioMetros() { return raioMetros; }
    public void setRaioMetros(int raioMetros) { this.raioMetros = raioMetros; }
    public LocalDate getDataImplantacao() { return dataImplantacao; }
    public void setDataImplantacao(LocalDate dataImplantacao) { this.dataImplantacao = dataImplantacao; }
    public List<PontoPoligono> getPontos() { return pontos; }
    
    public void adicionarPonto(PontoPoligono ponto) {
        this.pontos.add(ponto);
    }

    @Override
    public String toString() {
        return "Região: " + nomeLocal + " | Raio: " + raioMetros + "m | Implantada em: " + dataImplantacao + " | Pontos do Polígono: " + pontos.size();
    }
}