import requests
import json
import logging

url="https://api.binance.com"
symbols={'BTC':'BTCUSDT',}

#crea un logger
LOG=logging.getLogger('boxplot')

#configuración y formato del logger
handler = logging.FileHandler('boxplot_logs.log')
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
handler.setFormatter(formatter)

#agrega el handler al logger
LOG.addHandler(handler)

#logging.basicConfig(filename='./boxplot_logger.log')

"""

"""
def makePlot(symb):

    #sym=symbols[symb]

    response=requests.get(url+'/api/v1/trades?symbol='+symb)
        
    if response.status_code == 200:
        LOG.info('Request exitoso')
        info=response.json()
    else:
        LOG.error('Símbolo inválido')

makePlot('ETH')