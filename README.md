# app-acerte-o-Numero

## Jogo: Acerte o Número
### Objetivo:
O objetivo deste jogo é que o usuário adivinhe o número sorteado pelo aplicativo antes que reste apenas o número sorteado no intervalo de 1 a 100.

### Interface do Usuário:
Ao iniciar o aplicativo, o usuário será apresentado a uma tela com os seguintes elementos:

### Intervalo: 
Um gráfico ou texto que exibe o intervalo atual entre os números, inicialmente de 1 a 100.

### Entrada de Número: 
Um campo de entrada onde o usuário pode digitar o número que ele acredita ser o correto.

### Botão "Chutar": 
Um botão que o usuário deve clicar para enviar o número que ele digitou para verificar.

### Status do Jogo: 
Uma área na parte inferior da tela que exibe o status atual do jogo.

## Regras do Jogo:
1- O aplicativo gera aleatoriamente um número entre 1 e 100 que o usuário deve adivinhar.
2- O usuário digita um número no campo de entrada.
3- Ao clicar no botão "Chutar", o aplicativo verifica o número digitado pelo usuário e compara com o número sorteado.
4-Se o número digitado pelo usuário for igual ao número sorteado, o aplicativo exibe uma mensagem de "Você Ganhou!" e altera o status do jogo para "Ganhou".
5-Se o número estiver fora do intervalo entre 1 e 100, o aplicativo exibe uma mensagem de "Você Perdeu!" e altera o status do jogo para "Perdeu".
6-Se o número digitado for maior ou menor que o número sorteado, o aplicativo fornece uma dica ao usuário indicando se o número é maior ou menor e continua o jogo.
7-O jogo continua até que o usuário acerte o número sorteado.

## Exemplo de Fluxo de Jogo:
Intervalo: 1 a 100
O usuário digita "50" e clica em "Chutar".
O aplicativo informa que o número é menor do que o número sorteado.
Intervalo: 51 a 100
O usuário digita "75" e clica em "Chutar".
O aplicativo informa que o número é maior do que o número sorteado.
Intervalo: 51 a 74
O usuário digita "63" e clica em "Chutar".
O aplicativo informa que o número é menor do que o número sorteado.
Intervalo: 64 a 74
O usuário digita "70" e clica em "Chutar".
O aplicativo informa que o número é menor do que o número sorteado.
Intervalo: 71 a 74

(hipótese 1)
O usuário digita "73(numero sorteado)" e clica em "Chutar".
O aplicativo informa que o usuario ganhou

(hipótese2)
O usuário digita "73(não é o valor certo)" e clica em "Chutar"
O aplicativo informa que o número é maior do que o número sorteado.
Intervalo: 71 a 73  
O aplicativo informa que o usuário perdeu o jogo.
pois a resposta obvia seria 72.
