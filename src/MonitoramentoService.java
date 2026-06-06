import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MonitoramentoService {
    
    private List<RegiaoUrbana> regioes;
    private List<Equipamento> equipamentos;
    private List<LeituraTermica> todasLeituras;
    
    private int contadorLeituras = 1;

    public MonitoramentoService() {
        this.regioes = new ArrayList<>();
        this.equipamentos = new ArrayList<>();
        this.todasLeituras = new ArrayList<>();
    }

    // --- CADASTRO ---
    public void cadastrarRegiao(RegiaoUrbana regiao) {
        regioes.add(regiao);
        System.out.println("✅ Região cadastrada com sucesso: " + regiao.getNomeLocal());
    }

    public void cadastrarEquipamento(Equipamento equipamento) {
        equipamentos.add(equipamento);
        System.out.println("✅ Equipamento cadastrado com sucesso na região: " + equipamento.getRegiao().getNomeLocal());
    }

    // --- LISTAGEM ---
    public List<RegiaoUrbana> getRegioes() { return regioes; }
    public List<Equipamento> getEquipamentos() { return equipamentos; }

    // --- BUSCA ---
    public Equipamento buscarEquipamentoPorId(int id) {
        for (Equipamento eqp : equipamentos) {
            if (eqp.getIdEquipamento() == id) {
                return eqp;
            }
        }
        return null;
    }

    // --- ATUALIZAÇÃO ---
    public void atualizarStatusEquipamento(int idEquipamento, String novoStatus) {
        Equipamento eqp = buscarEquipamentoPorId(idEquipamento);
        if (eqp != null) {
            eqp.setStatusOperacao(novoStatus);
            System.out.println("🔄 Status do equipamento atualizado para: " + novoStatus);
        } else {
            System.out.println("❌ Equipamento não encontrado!");
        }
    }

    // --- LÓGICA DE NEGÓCIO ---
    public void registrarLeituraTemperatura(Equipamento equipamento, double temperatura) {
        String status;

        if (temperatura >= 35.0) {
            status = "CRÍTICO"; // Vermelho
        } else if (temperatura >= 25.0) {
            status = "ATENÇÃO"; // Laranja
        } else {
            status = "NORMAL";  // Amarelo
        }

        LeituraTermica novaLeitura = new LeituraTermica(contadorLeituras++, equipamento, temperatura, status, LocalDateTime.now());
        
        todasLeituras.add(novaLeitura);
        equipamento.adicionarLeitura(novaLeitura);

        System.out.println("-> Nova leitura processada! " + novaLeitura.toString());
    }

    public void listarAlertasCriticos() {
        System.out.println("\n=== RELATÓRIO DE ILHAS DE CALOR CRÍTICAS ===");
        boolean encontrou = false;
        
        for (LeituraTermica leitura : todasLeituras) {
            if (leitura.getStatusTermico().equals("CRÍTICO")) {
                System.out.println("- Região: " + leitura.getEquipamento().getRegiao().getNomeLocal() + 
                                   " | Equipamento ID: " + leitura.getEquipamento().getIdEquipamento() +
                                   " | Temp: " + leitura.getTemperaturaRegistrada() + "°C");
                encontrou = true;
            }
        }
        
        if (!encontrou) {
            System.out.println("Nenhuma ilha de calor crítica detectada. Tudo sob controle!");
        }
        System.out.println("============================================\n");
    }
}