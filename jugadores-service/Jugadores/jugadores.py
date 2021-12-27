import logging
import os
import string

import requests

from flask_restx import Resource, reqparse, Namespace, fields



equiposPuerto = "8080" if (os.environ.get("EQUIPOS_PORT_NUMBER") is None) else os.environ.get("EQUIPOS_PORT_NUMBER")
equiposIp = "equipos" if (os.environ.get("EQUIPOS_HOSTNAME_VALUE") is None) else os.environ.get("EQUIPOS_HOSTNAME_VALUE")
servicios = "" if (os.environ.get("EQUIPOS_HOSTNAME_VALUE") is None) else "." + os.environ.get("EQUIPOS_HOSTNAME_VALUE")
LISTAJUGADOR = []

api = Namespace('jugadores', description='Jugadores related operations')
resource_fields = api.model('Resource', {
    'name': fields.String,
})
def encuentra_jugador(nombre):
    jugador = [jugador for jugador in LISTAJUGADOR if jugador['nombre'] == nombre]
    if jugador:
        return jugador[0], 200
    return {'message': 'Jugador no encontrado conf nombre {}'.format(nombre)}, 404


class Jugador(Resource):
    equipos = {
        "name": "http://{0}{1}:{2}".format(equiposIp, servicios, equiposPuerto),
        "endpoint": "equipos"

    }

    parser = reqparse.RequestParser()

    parser.add_argument('dorsal',
                        type=int,
                        required=True,
                        help="Dorsal del jugador."
                        )
    parser.add_argument('idequipo',
                        type=int,
                        required=False,
                        help="Id del equipo."
                        )

    def get(self, nombre):
        return encuentra_jugador(nombre)

    @api.expect(resource_fields)
    def post(self, nombre):
        if len(list(filter(lambda x: x == nombre, LISTAJUGADOR))) > 0:
            return {'message': "An item with name '{}' already exists.".format(nombre)}, 400
        jugador = Jugador.parser.parse_args()
        jugador['nombre'] = nombre
        LISTAJUGADOR.append(jugador)

        return jugador, 201


class Jugadores(Resource):
    def get(self):
        return LISTAJUGADOR


class JugadorConEquipo(Resource):
    def get(self, nombre):

        jugador, code = encuentra_jugador(nombre)
        if code != 200:
            return jugador
        else:
            if 'idequipo' not in jugador:
                return {'message': 'idequipo no está dentro de jugador {}'.format(nombre)}, 404
            else:
                headers = {'Accept': "application-json"}
                url = "{}/{}".format(Jugador.equipos['name'], jugador['idequipo'])
                #url = "http://127.0.0.1:63700/equipos/61a00cda0304fe14de7d824c"
                logging.info("Calling URL==>" + url)
                equipo = requests.get(url, timeout=10.0)
                jugador['equipo'] = equipo.json()
                return jugador
