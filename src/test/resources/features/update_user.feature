# language: es
Característica: Modificar usuarios
  como usuario de reqres
  quiero actualizar la información de usuarios
  para poder mantenerlos actualizados.

  Escenario: Actualizar usuario exitosamente
    Dado que usuario admin modifica correctamente datos del usuario con id 2
    Entonces el puede actualizar la información del usuario