import requests as rq
import json 

cotacoes = rq.get(" https://economia.awesomeapi.com.br/last/USD-BRL,EUR-BRL,BTC-BRL")
cotacoes = cotacoes.json()
#Filtra pelos parametros 
cotacao_dolar = cotacoes['USDBRL']["bid"]
print(cotacao_dolar)
#print(cotacoes)
