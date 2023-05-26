import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.m6z1.test_0525.SecondActivity
import com.m6z1.test_0525.databinding.ActivityFinalBinding
import org.json.JSONObject
import java.io.File
import java.io.FileOutputStream

class FinalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFinalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 이전 액티비티로부터 전달받은 값 가져오기
        val radioValue = intent.getStringExtra(SecondActivity.RADIO_BUTTON_VALUE_KEY)
        val textValue = intent.getStringExtra(ThirdActivity.VIEW_VALUE_KEY)

        // JSON 객체 생성
        val jsonObject = JSONObject()
        jsonObject.put("radioValue", radioValue)
        jsonObject.put("textValue", textValue)

        // JSON 객체를 문자열로 변환
        val jsonString = jsonObject.toString()

        // JSON 파일로 저장하는 버튼 클릭 이벤트 처리
        binding.btnDownload.setOnClickListener {
            saveJsonToFile(jsonString)
        }
    }

    private fun saveJsonToFile(jsonString: String) {
        val fileName = "data.json"
        val file = File(filesDir, fileName)

        try {
            // JSON 파일로 저장
            val fileOutputStream = FileOutputStream(file)
            fileOutputStream.write(jsonString.toByteArray())
            fileOutputStream.close()

            // 다운로드 완료 메시지 표시
            showToast("JSON 파일 다운로드 완료: ${file.absolutePath}")
        } catch (e: Exception) {
            e.printStackTrace()
            showToast("JSON 파일 다운로드 실패")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
