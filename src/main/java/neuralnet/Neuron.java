package neuralnet;

import java.util.Collection;
import java.util.List;

public abstract class Neuron
{
	protected List<Double> weights;
	protected Double bias;
	protected Integer version = 1;
	
	public Neuron(Collection<Double> weights, Double bias)
	{
		this.weights.addAll(weights);
		this.bias = bias;
	}
	
	public Integer getVers()
	{
		return version;
	}
	
	protected void incVers()
	{
		version++;
	}
}
