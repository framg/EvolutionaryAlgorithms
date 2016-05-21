import com.benchmark.Rand;
import com.benchmark.Records;
import com.benchmark.cec.cec15.CEC15Benchmark;
import com.benchmark.seeds;

/**
 * Created by framg on 08/05/2016.
 */
public class LSHADE_SPSTest {

    @org.junit.Test
    public void LSHADE_test(){

        Configuration.records = new Records();
        int F = 5;
        //for(int F=1; F<=1; F++) {
        for (int DIM = 10; DIM <= 10; DIM += 20) {
            Configuration.benchmark = new CEC15Benchmark(DIM, F);
            Configuration.records.startRecord();
            for(int run =0; run<1; run++) {
                Configuration.D = DIM;
                Configuration.nF = F;
                Configuration.maxfunevals = 10000 * DIM;
                Configuration.NP = 540;
                Configuration.CR = 0.5;
                Configuration.EarlyStop = "fitness";
                Configuration.ConstraintHandling = "Interpolation";

                Rand rand = new Rand(seeds.getSeed(Configuration.nF));
                Configuration.rand = rand;
                // com.benchmark.cec.cec05.benchmark com.benchmark.cec.cec05.benchmark = new com.benchmark.cec.cec05.benchmark();
                // com.benchmark.cec.cec05.test_func com.benchmark.cec.cec05.test_func = com.benchmark.cec.cec05.benchmark.testFunctionFactory(Configuration.nF, Configuration.D);
                // Configuration.com.benchmark.cec.cec05.benchmark = com.benchmark.cec.cec05.test_func;
                System.out.println("Fun: "+ F + "Run: " + run + "DIM: " + DIM);
                LSHADE_SPS algorithm = new LSHADE_SPS();
                algorithm.execute();

            }
            Configuration.records.endRecord(F, DIM);
            //Configuration.records.write(DIM, F, "LSHADE_SPS", false);
        }
        //}
        Configuration.records.exportExcel("LSHADE_SPS");
    }

}