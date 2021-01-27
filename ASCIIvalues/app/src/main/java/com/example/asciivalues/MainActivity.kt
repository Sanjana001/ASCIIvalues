package com.example.asciivalues

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var ascii_value = arrayOf<String>("NUL","SOH","STX","ETX","EOT","ENQ","ACK","BEL","BS","HT","LF","VT","FF","CR","SO","SI","DLE","DC1","DC2","DC3","DC4","NAK","SYN","ETB","CAN","EM","SUB",
    "ESC","FS","GS","RS","US"," ","!","\"","#","$","%","&","'","(",")","*","+",",","-",".","/","0","1","2","3","4","5","6","7","8","9",":",";","<","=",">","?","@","A","B","C","D","E","F","G","H","I","J",
    "K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","[","\\","]","^","_","`","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","{",
    "|","}","~","del")
    private var ascii_desc = arrayOf<String>("Null","Start of Heading","Start of Text","End of Text","End of Transmission","Enquiry","Acknowledgment","Bell","Back Space","Horizontal Tab","Line Feed","Vertical Tab",
            "Form Feed","Carriage Return","Shift Out","Shift In","Data Link Escape","Device Control 1","Device Control 2","Device Control 3","Device Control 4","Negative Acknowledge","Synchronous Idle",
            "End of Transmit Block","Cancel","End Of Medium","Subtitle","Escape","File Separator","Group Separator","Record Separator","Unit Separator","Space","Exclamation Mark","Double Quotes","Number","Dollar","Percent",
            "Ampersand","Single Quote","Open bracket","Close bracket","Asterisk","Plus","Comma","Hyphen","Period or full stop","Slash or divide","Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Colon","Semicolon",
            "Less than","Equals","Greater Than","Question Mark","At sign","Opening bracket","Backslash","Closing bracket","Caret","Underscore","Grave accent", "Opening brace","Vertical bar","Closing brace",
            "Equivalency - tilde","Delete")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listenerEvent(seekbar)
        result.setOnClickListener{
            makeText(editText.text.toString(),ascii_value.indexOf(editText.text.toString()))
        }
        reset.setOnClickListener{
            editText.setText("NUL")
            seekbar.setProgress(0)
        }
    }
    @SuppressLint("SetTextI18n")
    private fun makeText(text: String?, index: Int?){
        if(index != -1) {
            editText.setText(text)
            seekbar.setProgress(index!!)
            html.text = text + "/" + index.toString()
            if (index >= 65 && index <= 90) character.text = "Lowercase " + text
            else if (index >= 97 && index <= 122) character.text = "Uppercase " + text
            else if (index > 90 && index < 97) character.text = ascii_desc.get(index - 26)
            else if (index > 122) character.text = ascii_desc.get(index - 52)
            else character.text = ascii_desc.get(index)
        }
    }
    private fun listenerEvent(seekbar: SeekBar?) {
        seekbar?.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                makeText(ascii_value.get(seekbar.progress.toString().toInt()!!),seekbar.progress.toString().toInt())
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }
}