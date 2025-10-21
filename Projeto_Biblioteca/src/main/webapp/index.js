// Função para gerenciar a exibição de conteúdo com base na seleção do botão de rádio
// ===============================================================
document.addEventListener("DOMContentLoaded", function () {
    const radioButtons = document.querySelectorAll('input[name="path"]');
    const contentSections = document.querySelectorAll(".content-section");

    // Função para atualizar o conteúdo visível
    function updateContent() {
        const selectedRadio = document.querySelector(
            'input[name="path"]:checked'
        );
        if (selectedRadio) {
            const targetId = selectedRadio.id + "-content";

            // Esconde todas as seções
            contentSections.forEach((section) => {
                section.style.display = "none";
            });

            // Mostra a seção alvo
            const targetSection = document.getElementById(targetId);
            if (targetSection) {
                targetSection.style.display = "block";
            }
        }
    }

    // Adiciona o listener para cada botão de rádio
    radioButtons.forEach((radio) => {
        radio.addEventListener("change", updateContent);
    });

    // Garante que o conteúdo inicial seja exibido corretamente
    updateContent();
});

// ===============================================================

// Função para validar os campos de senha ao cadastrar um usuario
const form = document.getElementById('formCadastro');
const spanConfirmarSenha = document.getElementById('spanConfirmarSenha');
const senha1Input = document.getElementById('senha');
const senha2Input = document.getElementById('confirmarSenha');

form.addEventListener('submit', function(event) {
  event.preventDefault();

  if (senha1Input.value === senha2Input.value) {
    form.submit(); 
  } else {
    spanConfirmarSenha.style.color = "red";
    senha2Input.style.border = "red 1px solid";
    senha2Input.focus();
  }
});

// ===============================================================


// para pegar o valor dentro do input da imagem e colocar no elemento img

document.getElementById("imageURL").addEventListener("input", function() {
    var imageUrl = this.value;
    var imgTag = document.getElementById("image");

    if (imageUrl) {
        imgTag.src = imageUrl;
        imgTag.style.display = "block"; // Exibe a imagem
    } else {
        imgTag.style.display = "none"; // Esconde a imagem caso o campo esteja vazio
    }
});
