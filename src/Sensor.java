import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sensor {
    
    private int idSensor;
    private RegiaoUrbana regiao; // A Chave Estrangeira vira o próprio Objeto!
    private String tipoSensor;
    private LocalDate dataAtivacao;
    private List<AlertaTermico> historicoAlertas; // O relacionamento 1 para N (1 Sensor tem N Alertas)

    // Construtor vazio
    public Sensor() {
        this.historicoAlertas = new ArrayList<>(); // Inicializa a lista vazia para evitar NullPointerException
    }

    // Construtor completo
    public Sensor(int idSensor, RegiaoUrbana regiao, String tipoSensor, LocalDate dataAtivacao) {
        this.idSensor = idSensor;
        this.regiao = regiao;
        this.tipoSensor = tipoSensor;
        this.dataAtivacao = dataAtivacao;
        this.historicoAlertas = new ArrayList<>();
    }

    // Getters e Setters
    public int getIdSensor() { return idSensor; }
    public void setIdSensor(int idSensor) { this.idSensor = idSensor; }

    public RegiaoUrbana getRegiao() { return regiao; }
    public void setRegiao(RegiaoUrbana regiao) { this.regiao = regiao; }

    public String getTipoSensor() { return tipoSensor; }
    public void setTipoSensor(String tipoSensor) { this.tipoSensor = tipoSensor; }

    public LocalDate getDataAtivacao() { return dataAtivacao; }
    public void setDataAtivacao(LocalDate dataAtivacao) { this.dataAtivacao = dataAtivacao; }

    public List<AlertaTermico> getHistoricoAlertas() { return historicoAlertas; }
    
    // Método extra para facilitar a adição de alertas na lista
    public void adicionarAlerta(AlertaTermico alerta) {
        this.historicoAlertas.add(alerta);
    }

    @Override
    public String toString() {
        return "Sensor ID: " + idSensor + " | Tipo: " + tipoSensor + " | Região: " + regiao.getNomeLocal() + " | Alertas registrados: " + historicoAlertas.size();
    }
}