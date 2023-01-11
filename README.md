# TradeStudyProject
#
**Автор**: Сумцов Данило

**Перелік необхідного програмного забезпечення:**
Android Studio актуальної версії, встановлений пакет ANDROID SDK версії не нижче 23,
налаштований Android Emulator або підключений фізичний пристрій в режимі USB\WIFI отладки

**Процедури встановлення, конфігурації та запуску мого проекту:**
Завантажити або склонувати файли проекту в свою директорію,
відкрити його за допомогою _Android Studio_, середовище має автоматично
завантажити необхідні версії _Gradle_ плагіну і _build_ файлів

**Головний _Activity_ з якого стартує проект:** 

    class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val strategyFragment = StrategyFragment()
    private val tipsFragment = TipsFragment()
    private val vocsFragment = VocabularyFragment()

        override fun init() {
            super.init()
            with(binding) {
                bnv.setOnItemSelectedListener {
                    when (it.itemId) {
                        R.id.strategy -> openFrag(strategyFragment, false)
                        R.id.tips -> openFrag(tipsFragment, false)
                        R.id.vocabulary -> openFrag(vocsFragment, false)
                    }
                    true
                }
                bnv.selectedItemId = R.id.strategy
            }
        }

    }


**Функціональні вимоги до проекту:**
1. Система повинна функціонувати на більшості пристроїв
з операційною системою Android версії 6.0 та вище
2. Система має містити наступні екрани: _Стартегії, Поради, Словник, Обране_
3. Система має мати функціональність збереження користувачем статей до _"Обраних"_
4. Система має мати зберігати інформацію, щодо обраних користувачем статей,
в локальному сховищі
5. Користувач має мати можливість перейти до будь-якої зі збережених статей з розділу _"Обране"_

**Нефункціональні вимоги до проекту:**
1. Додаток повиннен мати зручний та зрозумілий UI/UX інтерфейс
2. Контент додатку має зберігатись у вигляді string.xml ресурсів
3. Очікуваний час завантаження контенту до 2000мс
