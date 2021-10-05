# language: pt

Funcionalidade: Propondo varios lances com variaveis

Cenario: Propondo varios lances validos com variaveis
   Dado um lance de 10.0 reais do usuario "fulano"
   E um lance de 15.0 reais do usuario "beltrano" 
   Quando propoe os lances com variaveis ao leilao 
   Entao os lances com variaveis sao aceitos
   