package TranDucManh_25020258_Week5.Bai03.src;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class xuly {
    public static String count(String str){
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '.' || c == '?' || c=='!') {
                str = str.replace(String.valueOf(c), "");
            }
            if (Character.isUpperCase(c)){
                str = str.replace(c, Character.toLowerCase(c));
            }
        }
        return str;
    }

    
}

public class chap3 {    
    public static void main(String[] args) {
        Map<String, Integer> wordCount = new HashMap<>();
        String str ="In the grand tapestry of human history, the definition of creativity has always been tethered to the soul. From the charcoal sketches on cave walls to the complex symphonies of the Romantic era, art was seen as the ultimate manifestation of human consciousness. However, as we move deeper into the 21st century, a new protagonist has entered the stage: Artificial Intelligence. This technological shift is not merely a change in tools; it is a fundamental re-evaluation of what it means to create.\n" + //
                "\n" + //
                "For decades, computers were viewed as rigid calculators, capable of executing logic but devoid of imagination. Today, generative models can compose hauntingly beautiful melodies, draft intricate legal briefs, and paint surreal landscapes that rival the masters. This evolution has sparked a global debate. Critics argue that AI-generated content is a \"hollow mimicry,\" a statistical arrangement of existing human data without the weight of lived experience. They fear that by automating the creative process, we risk diluting the very essence of inspiration, turning art into a commodity produced at the click of a button.\n" + //
                "\n" + //
                "Yet, a more nuanced perspective suggests that AI is not a replacement for the artist, but rather a sophisticated mirror. Just as the invention of photography did not kill painting but instead pushed it toward Impressionism and Abstract Expressionism, AI is forcing us to redefine our boundaries. When a machine can handle the technical labor—the shading of a digital portrait or the basic structure of a code—the human creator is liberated to focus on high-level conceptualization. The \"art\" then shifts from the execution to the intent, the curation, and the emotional spark that initiates the prompt.\n" + //
                "\n" + 
                "Furthermore, AI serves as a democratizing force. In the past, the barrier to entry for many creative fields was high, requiring years of technical training or expensive equipment. Now, an aspiring storyteller with a vision but no formal drawing skills can use AI to storyboard a film. A scientist with a breakthrough theory can use large language models to articulate complex ideas to a broader audience. In this sense, technology is expanding the \"creative sandbox,\" allowing a more diverse range of voices to contribute to the global cultural conversation.\n" + //
                "\n" + //
                "However, this new era also brings ethical shadows. The questions of copyright, intellectual property, and the \"human-ness\" of labor remain largely unanswered. If an AI creates a masterpiece based on the styles of thousands of uncompensated human artists, who truly owns the result? Moreover, there is the risk of \"algorithmic bias,\" where AI models inadvertently suppress certain cultural nuances in favor of the most statistically dominant data points.\n" + //
                "\n" + //
                "In conclusion, the intersection of AI and creativity is not a zero-sum game. It is a complex, evolving partnership. As we navigate this frontier, the challenge for humanity is not to resist the machine, but to use it as a catalyst for a new kind of brilliance. The future of creativity will likely be a hybrid one, where the cold efficiency of the algorithm meets the warm, unpredictable, and noble spirit of human intuition. The brush may have changed, but the hand that guides the vision remains, as always, irreplaceable." ;
   
        String ans = xuly.count(str);
        String[] words = ans.split("\\s+");
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        int maxCount = Collections.max(wordCount.values());
        wordCount.forEach((word, count) -> {
            if (count == maxCount) {
                System.out.println("Most frequent word ís :  "+ word );
            }
            // if (count == 1) {
            //     System.out.println("Unique word : " + word);
            // }
        });
    }
}
