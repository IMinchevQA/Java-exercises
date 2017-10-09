/**
 * Created by Ivan Minchev on 4/28/2017.
 */
public class Test {
    {
        int[] src1 = new int[10000];
        int[] src2 = new int[20000];

        int[] dst1 = new int[10000];
        int[] dst2 = new int[20000];

        Stopwatch sw = new Stopwatch();
        sw.Start();
        Array.Copy(src1, dst1, src1.Length);
        sw.Stop();
        Console.WriteLine(sw.Elapsed);

        sw.Start();
        Array.Copy(src2, dst2, src2.Length);
        sw.Stop();
        Console.WriteLine(sw.Elapsed);


    }
