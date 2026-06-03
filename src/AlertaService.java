import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlertaService {
    
    // Nossas listas que simulam as tabelas do Banco de Dados
    private List<RegiaoUrbana> regioes;
    private List<Sensor> sensores;
    private List<AlertaTermico> todosAlertas;
    
    // Simulando o Auto-Increment (Primary Key) do banco
    private int contadorAlertas = 1;

    public AlertaService() {
        this.regioes = new ArrayList<>();
        this.sensores = new ArrayList<>();
        this.todosAlertas = new ArrayList<>();
    }

    // --- MÉTODOS DE CADASTRO (Simulando o INSERT) ---
    public void cadastrarRegiao(RegiaoUrbana regiao) {
        regioes.add(regiao);
        System.out.println("Região cadastrada com sucesso: " + regiao.getNomeLocal());
    }

    public void cadastrarSensor(Sensor sensor) {
        sensores.add(sensor);
        System.out.println("Sensor cadastrado com sucesso na região: " + sensor.getRegiao().getNomeLocal());
    }

    public List<RegiaoUrbana> getRegioes() {
        return regioes;
    }

    public List<Sensor> getSensores() {
        return sensores;
    }

    // --- LÓGICA DE NEGÓCIO (O Diferencial do Projeto) ---
    
    // Método que recebe uma temperatura, avalia a gravidade e cria o alerta
    public void registrarLeituraTemperatura(Sensor sensor, double temperatura) {
        String severidade;

        if (temperatura >= 35.0) {
            severidade = "#FF0000"; // Vermelho - Crítico (Muito Calor)
        } else if (temperatura >= 25.0) {
            severidade = "#FFA500"; // Laranja - Atenção (Calor Moderado)
        } else {
            severidade = "#F5F527"; // Amarelo - Normal
        }

        // Instancia o novo Alerta com a data atual
        AlertaTermico novoAlerta = new AlertaTermico(contadorAlertas++, sensor, temperatura, severidade, LocalDate.now());
        
        // Salva na lista geral do sistema
        todosAlertas.add(novoAlerta);
        // E salva no histórico do próprio sensor (Relacionamento 1:N)
        sensor.adicionarAlerta(novoAlerta);

        System.out.println("-> Nova leitura processada! " + novoAlerta.toString());
    }

    public void listarAlertasCriticos() {
        System.out.println("\n=== RELATÓRIO DE ILHAS DE CALOR CRÍTICAS ===");
        boolean encontrou = false;
        
        for (AlertaTermico alerta : todosAlertas) {
            if (alerta.getNivelSeveridade().equals("#FF0000")) {
                System.out.println("- Região: " + alerta.getSensor().getRegiao().getNomeLocal() + 
                                   " | Temp: " + alerta.getTemperaturaRegistrada() + "°C");
                encontrou = true;
            }
        }
        
        if (!encontrou) {
            System.out.println("Nenhuma ilha de calor crítica detectada. Tudo sob controle!");
        }
        System.out.println("============================================\n");
    }
}