package com.example.deprerisk.persistence

import com.example.deprerisk.persistence.room.entity.BeckInventoryEntity

class BeckQuestioners {
     fun questions(): List<BeckInventoryEntity> {
        return listOf(
            BeckInventoryEntity(
                1,
                "1. Tristeza",
                "No me siento triste.",
                "Me siento triste gran parte del tiempo",
                "Me siento triste todo el tiempo.",
                "Me siento tan triste o soy tan infeliz que no puedo soportarlo.",
                "",
                "",
                ""
            ),
            BeckInventoryEntity(
                2,
                "2. Pesimismo",
                "No estoy desalentado respecto de mi futuro.",
                "Me siento más desalentado respecto de mi futuro que lo que solía estarlo.",
                "No espero que las cosas funcionen para mi.",
                "Siento que no hay esperanza para mi futuro y que sólo puede empeorar.",
                "",
                "",
                ""
            ),
            BeckInventoryEntity(
                3,
                "3. Fracaso",
                "No me siento como un fracasado.",
                "He fracasado más de lo que hubiera debido.",
                "Cuando miro hacia atrás, veo muchos fracasos.",
                "Siento que como persona soy un fracaso total.",
                "",
                "",
                ""
            ),
            BeckInventoryEntity(
                4,
                "4. Pérdida de Placer",
                "Obtengo tanto placer como siempre por las cosas de las que disfruto.",
                "No disfruto tanto de las cosas como solía hacerlo.",
                "Obtengo muy poco placer de las cosas que solía disfrutar.",
                "No puedo obtener ningún placer de las cosas de las que solía disfrutar.",
                "",
                "",
                ""
            ),
            BeckInventoryEntity(
                5,
                "5. Sentimientos de Culpa",
                "No me siento particularmente culpable.",
                "Me siento culpable respecto de varias cosas que he hecho o que debería haber hecho.",
                "Me siento bastante culpable la mayor parte del tiempo.",
                "Me siento culpable todo el tiempo.",
                "",
                "",
                ""
            ),
            BeckInventoryEntity(
                6,
                "6. Sentimientos de Castigo",
                "0 No siento que este siendo castigado",
                "1 Siento que tal vez pueda ser castigado.",
                "2 Espero ser castigado.",
                "3 Siento que estoy siendo castigado.",
                "",
                "",
                ""
            ),
            BeckInventoryEntity(
                7,
                "7. Disconformidad con uno mismo.",
                "Siento acerca de mi lo mismo que siempre.",
                "He perdido la confianza en mí mismo.",
                "Estoy decepcionado conmigo mismo.",
                "No me gusto a mí mismo.",
                "",
                "",
                ""
            ),
            BeckInventoryEntity(
                8,
                "8. Autocrítica",
                "No me critico ni me culpo más de lo habitual",
                "Estoy más crítico conmigo mismo de lo que solía estarlo",
                "Me critico a mí mismo por todos mis errores",
                "Me culpo a mí mismo por todo lo malo que sucede.",
                "",
                "",
                ""
            ),
            BeckInventoryEntity(
                9,
                "9. Pensamientos o Deseos Suicidas",
                "No tengo ningún pensamiento de matarme.",
                "He tenido pensamientos de matarme, pero no lo haría",
                "Querría matarme",
                "Me mataría si tuviera la oportunidad de hacerlo.",
                "",
                "",
                ""
            ),
            BeckInventoryEntity(
                10,
                "10. Llanto",
                "No lloro más de lo que solía hacerlo.",
                "Lloro más de lo que solía hacerlo",
                "Lloro por cualquier pequeñez.",
                "Siento ganas de llorar pero no puedo.",
                "",
                "",
                ""
            ),
            BeckInventoryEntity(
                11,
                "11. Agitación",
                "0 No estoy más inquieto o tenso que lo habitual.",
                "1 Me siento más inquieto o tenso que lo habitual.",
                "2 Estoy tan inquieto o agitado que me es difícil quedarme quieto",
                "3 Estoy tan inquieto o agitado que tengo que estar siempre en movimiento o haciendo algo.",
                "",
                "",
                ""
            ),
            BeckInventoryEntity(
                12,
                "12. Pérdida de Interés",
                "No he perdido el interés en otras actividades o personas.",
                "Estoy menos interesado que antes en otras personas o cosas.",
                "He perdido casi todo el interés en otras personas o cosas.",
                "Me es difícil interesarme por algo. ",
                "",
                "",
                ""
            ),
            BeckInventoryEntity(
                13,
                "13. Indecisión",
                "Tomo mis propias decisiones tan bien como siempre.",
                "Me resulta más difícil que de costumbre tomar decisiones",
                "Encuentro mucha más dificultad que antes para tomar decisiones.",
                "Tengo problemas para tomar cualquier decisión.",
                "",
                "",
                ""
            ),
            BeckInventoryEntity(
                14,
                "14. Desvalorización",
                "No siento que yo no sea valioso",
                "No me considero a mi mismo tan valioso y útil como solía considerarme",
                "Me siento menos valioso cuando me comparo con otros.",
                "Siento que no valgo nada.",
                "",
                "",
                ""
            ),
            BeckInventoryEntity(
                15,
                "15. Pérdida de Energía",
                "Tengo tanta energía como siempre.",
                "Tengo menos energía que la que solía tener.",
                "No tengo suficiente energía para hacer demasiado",
                "No tengo energía suficiente para hacer nada.",
                "",
                "",
                ""
            ),
            BeckInventoryEntity(
                16,
                "16. Cambios en los Hábitos de Sueño",
                "0 No he experimentado ningún cambio en mis hábitos de sueño.",
                "1a Duermo un poco más que lo habitual.",
                "1b Duermo un poco menos que lo habitual.",
                "2a Duermo mucho más que lo habitual.",
                "2b Duermo mucho menos que lo habitual",
                "3a Duermo la mayor parte del día",
                "3b  Me despierto 1-2 horas más temprano y no puedo volver a dormirme"
            ),
            BeckInventoryEntity(
                17,
                "17. Irritabilidad",
                "No estoy tan irritable que lo habitual.",
                "Estoy más irritable que lo habitual.",
                "Estoy mucho más irritable que lo habitual.",
                "Estoy irritable todo el tiempo.",
                "",
                "",
                ""
            ),
            BeckInventoryEntity(
                18,
                "18. Cambios en el Apetito",
                "0 No he experimentado ningún cambio en mi apetito.",
                "1a Mi apetito es un poco menor que lo habitual.",
                "1b Mi apetito es un poco mayor que lo habitual.",
                "2a Mi apetito es mucho menor que antes.",
                "2b Mi apetito es mucho mayor que lo habitual",
                "3a No tengo apetito en absoluto.",
                "3b. Quiero comer todo el día."
            ),
            BeckInventoryEntity(
                19,
                "19. Dificultad de Concentración",
                "Puedo concentrarme tan bien como siempre.",
                "No puedo concentrarme tan bien como habitualmente",
                "Me es difícil mantener la mente en algo por mucho tiempo.",
                "Encuentro que no puedo concentrarme en nada.",
                "",
                "",
                ""
            ),
            BeckInventoryEntity(
                20,
                "20. Cansancio o Fatiga",
                "No estoy más cansado o fatigado que lo habitual.",
                "Me fatigo o me canso más fácilmente que lo habitual.",
                "Estoy demasiado fatigado o cansado para hacer muchas de las cosas que solía hacer.",
                "Estoy demasiado fatigado o cansado para hacer la mayoría de las cosas que solía",
                "",
                "",
                ""
            ),
            BeckInventoryEntity(
                21,
                "21. Pérdida de Interés en el Sexo",
                "No he notado ningún cambio reciente en mi interés por el sexo.",
                "Estoy menos interesado en el sexo de lo que solía estarlo.",
                "Estoy mucho menos interesado en el sexo.",
                "He perdido completamente el interés en el sexo. ",
                "",
                "",
                ""
            )
        )
    }
}