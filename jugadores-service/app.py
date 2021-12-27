import logging
import sys

from flask import Flask
from flask_restx import Api, fields
from Jugadores.jugadores import api as ns1


from Jugadores.jugadores import Jugadores, Jugador, JugadorConEquipo

app = Flask(__name__)
api = Api(app, version="2.0" , title="Test equipos")

logging.basicConfig(stream=sys.stdout, level=logging.DEBUG)
api.add_namespace(ns1)

api.add_resource(Jugadores, '/jugadores')
api.add_resource(Jugador, '/jugador/<string:nombre>')
api.add_resource(JugadorConEquipo, '/jugador-con-equipo/<string:nombre>')

app.config['DEBUG'] = True

if __name__ == '__main__':
    app.run(host='0.0.0.0',port=5000)