package net.minecraftforge.cauldron.configuration;

import java.util.ArrayList;
import java.util.HashSet;

public class IntArraySetting extends ArraySetting<Integer> {
    private String value;
    private ConfigBase config;
    
    public IntArraySetting(ConfigBase config, String path, String def, String description)
    {
        super(path, def, description);
        this.value = def;
        
        this.config = config;
    }

    @Override
    public String getValue()
    {
        return value;
    }

    @Override
    public void setValue(String value)
    {
    	
        config.set(path, this.value = value);
    }

	@Override
	public void initArr(String array) {
		String[] potential_values = array.split(",");
		this.value_array = new ArrayList<Integer>(potential_values.length);
		this.value_set = new HashSet<Integer>(potential_values.length);
		for(String potval : potential_values)
		{
			try 
			{
				if(potval.length() == 0)	continue;
				
				this.value_array.add(Integer.parseInt(potval));
			} 
			catch ( Throwable t) 
			{
				System.out.println("[Thermos] Failed to add an option from config file");
				t.printStackTrace();
			}
		}
		this.value_set.addAll(value_array);
	}
}
