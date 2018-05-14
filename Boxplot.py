import requests
import json
import logging

url="https://api.binance.com"
symbols={'BTC':'BTCUSDT',}

LOG=logging.getLogger('boxplot')
logging.basicConfig(filename='./boxplot_logger.log')

"""

"""
def makePlot(symb):

    #sym=symbols[symb]

    response=requests.get(url+'/api/v1/trades?symbol='+sym)
        
    if response.status_code == 200:
        LOG.info('Request exitoso')
        info=response.json()
    else:
        LOG.error('Símbolo inválido')

makePlot('ETH')