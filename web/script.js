// --- 1. LÓGICA DE DADOS ESTÁTICOS (REQUISITO DA GLOBAL SOLUTION) ---
// Array de objetos simulando o retorno de uma API ou Banco de Dados
const alertasMockados = [
    { id: 101, local: "Centro - SP (Brasil)", temp: 39.5, nivel: "Crítico", cor: "red", data: "03/06/2026" },
    { id: 102, local: "Deserto de Mojave (EUA)", temp: 42.1, nivel: "Crítico", cor: "red", data: "03/06/2026" },
    { id: 103, local: "Madrid (Espanha)", temp: 34.2, nivel: "Atenção", cor: "orange", data: "03/06/2026" },
    { id: 104, local: "Kinshasa (Congo)", temp: 38.8, nivel: "Crítico", cor: "red", data: "03/06/2026" }
];

// --- 2. POPULAR O DASHBOARD (Se estivermos no index.html) ---
const listaAlertasDiv = document.querySelector("#lista-alertas");
const dadoCriticos = document.querySelector("#dado-criticos");

// Verifica se os elementos do dashboard existem na tela atual
if (listaAlertasDiv) {
    let htmlAlertas = "";
    let contCriticos = 0;

    // Percorre o Array (forEach) e monta o HTML
    alertasMockados.forEach(alerta => {
        if(alerta.nivel === "Crítico") contCriticos++;

        let corBorda = alerta.cor === "red" ? "#ef4444" : "#f59e0b";

        htmlAlertas += `
            <div class="alerta-item" style="border-left-color: ${corBorda}">
                <div>
                    <strong>${alerta.local}</strong>
                    <div style="font-size: 0.8rem; color: #94a3b8;">${alerta.data}</div>
                </div>
                <div style="font-weight: bold; color: ${corBorda};">
                    ${alerta.temp}°C
                </div>
            </div>
        `;
    });

    // Injeta na tela
    listaAlertasDiv.innerHTML = htmlAlertas;
    dadoCriticos.innerText = contCriticos;
}

// --- 3. LÓGICA DE REDIRECIONAMENTO DO MAPA (Sua Lógica Original) ---
const botao = document.querySelector("#botaoDePais");
const regiao = document.querySelector("#regiao");

const americaDoSul = [-24.599111, -62.101541];
const americaDoNorte = [48.3689, -99.9962];
const europa = [50.172500, 10.150000];
const africa = [5.0000, 20.0000];
const asia = [43.681111, 87.331111];
const oceania = [-15, 135];

// O botão também só adiciona evento se existir na tela
if (botao) {
    botao.addEventListener("click", () => {
        let area;
        if (regiao.value == "AS") area = americaDoSul;
        else if (regiao.value == "AN") area = americaDoNorte;
        else if (regiao.value == "EU") area = europa;
        else if (regiao.value == "AF") area = africa;
        else if (regiao.value == "AA") area = asia;
        else if (regiao.value == "OC") area = oceania;
        
        localStorage.setItem("area", JSON.stringify(area));
        window.location.href = "mapa.html";
    });
}