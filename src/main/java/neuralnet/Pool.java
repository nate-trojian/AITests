package neuralnet;

import java.util.ArrayList;
import java.util.List;

public class Pool
{
	List<Species> species;
	int curSpecies, curGenome, generation;
	double maxFitness;
	
	public Pool()
	{
		species = new ArrayList<Species>();
		curSpecies = 0;
		curGenome = 0;
		generation = 0;
	}
	
	public int generation()
	{
		return generation;
	}
	
	public int currentSpecies()
	{
		return curSpecies;
	}
	
	public int currentGenome()
	{
		return curGenome;
	}
}
