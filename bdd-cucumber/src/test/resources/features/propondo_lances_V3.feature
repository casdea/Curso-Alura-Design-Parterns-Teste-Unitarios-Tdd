# language: pt

Funcionalidade: Propondo lances

Cenario: Propondo um unico lance valido
 Dado um lance valido
 Quando propoe o lance
 Entao o lance eh aceito
 
 Cenario: Propondo varios lances validos
   Dado varios lances validos 
   Quando propoe os lances ao leilao 
   Entao os lances sao aceitos
   
 Cenario: Propondo varios lances validos com variaveis
   Dado um lance de 10.0 reais do usuario "fulano"
   E um lance de 15.0 do usuario "beltrano" 
   Quando propoe os lances ao leilao 
   Entao os lances sao aceitos