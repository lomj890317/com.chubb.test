# Solución — Examen Práctico

## Qué se implementó
*Se agrega endpoint para borrar clientes por id

## Cómo se implementó
Se agraga en cada capa, y se hace la persistencia con jdbcTemplate

## Cambios en base de datos / configuración
Se cambia a una base de datos H2 donde se agrega sus configuracion en el properties

## Dificultades encontradas
*Habia que ajustar algunas dependencias en el pom
*Mi equipo no estaba configurado el ambiente de desarrollo, me tuve que cambiar de equipo para no perder mucho tiempo

## Mejoras que podrían aplicarse
*Se podria aplicar arquitectura hexagonal para un mayor desacoplamiento
*Usar records con java  21 para la capa de model y enviar esos datros al controller previamnte transformandolos del entity a los records