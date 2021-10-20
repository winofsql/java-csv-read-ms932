import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Main2 {

    // *****************************************************
    // エントリポイント
    // *****************************************************
    public static void main(String[] args) {

        String target = "001.csv";
        try {
            // 開く
            FileInputStream sjis_file = new FileInputStream(target);
            InputStreamReader charset_stream = new InputStreamReader(sjis_file, "ms932");
            BufferedReader buffer = new BufferedReader(charset_stream);

            FileOutputStream utf8_file = new FileOutputStream("result.txt");
            OutputStreamWriter osw = new OutputStreamWriter(utf8_file, "utf-8");
            BufferedWriter bw = new BufferedWriter( osw );

            String line_buffer;
            String[] adata;
            String result;
            while (null != (line_buffer = buffer.readLine())) {
                adata = line_buffer.split(",");
                result = String.format(
                    "%s %s %s %d",
                     adata[0],
                     adata[1].substring(0, 2),
                     adata[5].replace("/", ""),
                     adata.length);
                System.out.println(result);
                bw.write(result);
                bw.newLine();
            }

            bw.close();
            osw.close();
            utf8_file.close();

            // 閉じる
            buffer.close();
            charset_stream.close();
            sjis_file.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
