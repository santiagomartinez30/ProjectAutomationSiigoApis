# language: es
Característica: Consulta de usuarios
  como usuario de reqres
  quiero consultar los diferentes usuarios
  para verificar su información

  Esquema del escenario: Consultar usuario existente
    Dado que usuario admin consulta un usuario por id <nro>
    Entonces el puede obtener información de usuario
    Ejemplos:
      | nro |
      | 2   |
      | 3   |

  Escenario: Consultar usuario no existente
    Dado que usuario admin consulta un usuario por id 9999
    Entonces el no puede obtener información de usuario