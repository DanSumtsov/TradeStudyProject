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
