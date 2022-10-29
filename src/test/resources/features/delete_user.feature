# language: es
Característica: Eliminar usuarios
  como usuario de regres
  quiero eliminar usuarios
  para conservar unicamente la información de usuarios activos

  Escenario: Eliminar usuario exitosamente
    Dado que usuario admin elimina correctamente datos del usuario con id 2
    Entonces el puede confirmar la eliminación del usuario