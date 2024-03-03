package com.example.sampleweb.domain.util;

import java.nio.charset.Charset;

import net.arnx.jsonic.JSON;
import net.arnx.jsonic.JSONException;

/**
 * JSONユーティリティクラス
 *
 */
public class JsonUtils {

    /** コンストラクタ */
    private JsonUtils() {
    }

    /**
     * NULL項目を出力しないJSON文字列を生成
     *
     * @param source
     * @return
     */
    public static String encode(Object source) {
        JSON json = new JSON();
        json.setPrettyPrint(true);
        return json.format(source);
    }

    /**
     * NULL項目を出力しないJSON文字列を生成
     *
     * @param source
     * @return
     */
    public static String encodeSuppressNull(Object source) {
        JSON json = new JSON();
        json.setSuppressNull(true);
        json.setPrettyPrint(true);
        return json.format(source);
    }

    /**
     * NULL項目を出力しないJSON文字列を生成 ★★[注意]★★ 不具合が発生する可能性がある関数なので使用しないこと
     *
     * @param source
     * @param charSet
     * @return
     */
    public static String encode(Object source, Charset charSet) {
        // 以下ロジックのようにStringでbyte配列にしてインスタンス"UTF-8"を作成すると文字化けが発生する
        return new String(encode(source).getBytes(), charSet);
    }

    /**
     * NULL項目を出力しないJSON文字列を生成
     *
     * @param source
     * @param charSet
     * @return
     */
    public static String encodeSuppressNull(Object source, Charset charSet) {
        return new String(encodeSuppressNull(source).getBytes(), charSet);
    }

    /**
     * 指定した文字列がJSON形式か
     *
     * @param source
     * @param charSet
     * @return
     */
    public static boolean isJSON(String str) {
        try {
            JSON.validate(str);
            return true;
        } catch (JSONException je) {
            return false;
        }
    }
}
