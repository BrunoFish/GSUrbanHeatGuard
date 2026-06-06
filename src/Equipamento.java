import java.util.ArrayList;
import java.util.List;

public class Equipamento {
    private int idEquipamento;
    private RegiaoUrbana regiao;
    private String tipoEquipamento;
    private String statusOperacao; // Ex: Ativo, Manutenção
    private List<LeituraTermica> historicoLeituras; // Relacionamento 1:N

    public Equipamento() {
        this.historicoLeituras = new ArrayList<>();
    }

    public Equipamento(int idEquipamento, RegiaoUrbana regiao, String tipoEquipamento, String statusOperacao) {
        this.idEquipamento = idEquipamento;
        this.regiao = regiao;
        this.tipoEquipamento = tipoEquipamento;
        this.statusOperacao = statusOperacao;
        this.historicoLeituras = new ArrayList<>();
    }

    public int getIdEquipamento() { return idEquipamento; }
    public void setIdEquipamento(int idEquipamento) { this.idEquipamento = idEquipamento; }
    public RegiaoUrbana getRegiao() { return regiao; }
    public void setRegiao(RegiaoUrbana regiao) { this.regiao = regiao; }
    public String getTipoEquipamento() { return tipoEquipamento; }
    public void setTipoEquipamento(String tipoEquipamento) { this.tipoEquipamento = tipoEquipamento; }
    public String getStatusOperacao() { return statusOperacao; }
    public void setStatusOperacao(String statusOperacao) { this.statusOperacao = statusOperacao; }
    public List<LeituraTermica> getHistoricoLeituras() { return historicoLeituras; }
    
    public void adicionarLeitura(LeituraTermica leitura) {
        this.historicoLeituras.add(leitura);
    }

    @Override
    public String toString() {
        return "Equipamento ID: " + idEquipamento + " | Tipo: " + tipoEquipamento + " | Status: " + statusOperacao + " | Região: " + regiao.getNomeLocal();
    }
}