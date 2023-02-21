package org.elasticsearch.plugin.hanlp.conf;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.document.sentence.Sentence;
import com.hankcs.hanlp.corpus.document.sentence.word.IWord;
import com.hankcs.hanlp.model.crf.CRFLexicalAnalyzer;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * elasticsearch-analysis-hanlp
 * elasticsearch-analysis-hanlp
 * Created by hezl on 2018-12-05.
 */
public class ConfigHelperTest {

    @Test
    public void getConfig() {
        System.out.println(HanLP.segment("你和对方但是"));
    }

    @Test
    public void testHanPSegment() {

//        Segment segment = HanLP.newSegment()
//                .enableAllNamedEntityRecognize(true)
//                .enableTranslatedNameRecognize(true)
//                .enableJapaneseNameRecognize(true)
//                .enableNameRecognize(true)
//                .enablePlaceRecognize(true)
//                .enableOrganizationRecognize(true);
//
//        CustomDictionary.add("c罗");
//        CustomDictionary.add("长安三万里");
        long startTime = System.currentTimeMillis();
//        System.out.println(segment.seg("追光新作《长安三万里》贴片预告曝光，李白胸怀大鹏之志豪情万丈"));
//        System.out.println("response cost: " + (System.currentTimeMillis() - startTime));

        System.out.println(this.getClass().getClassLoader().getResource("./data-for-1.7.5"));

        CRFLexicalAnalyzer analyzer = null;
        try {
            analyzer = new CRFLexicalAnalyzer();
            analyzer.enableCustomDictionary(true)
                    .enableAllNamedEntityRecognize(true)
                    .enableTranslatedNameRecognize(true)
                    .enableJapaneseNameRecognize(true)
                    .enableNameRecognize(true)
                    .enablePlaceRecognize(true)
                    .enableOrganizationRecognize(true);
            startTime = System.currentTimeMillis();
            String sentence = "新冠后遗症";
            Sentence st = analyzer.analyze(sentence);
            List<IWord> ls = st.wordList;


            System.out.println("response cost: " + (System.currentTimeMillis() - startTime));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}