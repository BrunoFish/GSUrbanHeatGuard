const botao = document.querySelector("#botaoDePais");
const regiao = document.querySelector("#regiao");
// coordenada da America do Sul no setView([-24.599111, -62.101541], 4)
const americaDoSul = [-24.599111, -62.101541];
// coordenada da America do Norte no setView([48.3689, -99.9962], 4)
const americaDoNorte = [48.3689, -99.9962];
// coordenada da Europa no setView([50.172500, 10.150000], 4)
const europa = [50.172500, 10.150000];
// coordenada da Africa no setView([5.0000, 20.0000], 4)
const africa = [5.0000, 20.0000];
// coordenada da Ásia no setView([43.681111, 87.331111], 4)
const asia = [43.681111, 87.331111];
// coordenada da Oceania no setView([-15, 135], 4)
const oceania = [-15, 135];

botao.addEventListener("click", () => {
    if (regiao.value == "AS") {
        area = americaDoSul
    } else if (regiao.value == "AN") {
        area = americaDoNorte
    } else if (regiao.value == "EU") {
        area = europa
    } else if (regiao.value == "AF") {
        area = africa
    } else if (regiao.value == "AA") {
        area = asia
    } else if (regiao.value == "OC") {
        area = oceania
    }
    localStorage.setItem("area", JSON.stringify(area));
    window.location.href = "mapa.html";
})

