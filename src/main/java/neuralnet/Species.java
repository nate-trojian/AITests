package neuralnet;

import java.util.ArrayList;
import java.util.List;

public class Species
{
	List<Genome> genomes;
	int staleness;
	private final int maxStaleness = 10;
	double maxFitness;
	
	public Species()
	{
		genomes = new ArrayList<Genome>();
		staleness = 0;
		maxFitness = 0;
	}
	
	public double maxFitness()
	{
		return maxFitness;
	}
	
	public boolean isStale()
	{
		return staleness >= maxStaleness;
	}
}
