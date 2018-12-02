package PROYPDSW.view;
import org.primefaces.model.chart.PieChartModel;
import com.google.inject.Inject;

import PROYPDSW.samples.entities.Iniciativa;
import PROYPDSW.samples.services.ExcepcionServicesIniciativa;
import PROYPDSW.samples.services.ServicesIniciativa;


import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@SuppressWarnings("deprecation")
@ManagedBean (name="estadisticasBean")
public class EstadisticasBean extends BasePageBean{
	@Inject
	private ServicesIniciativa service;
	private String dataChart;
	private String dataBarChart;
	
	public String getDataBarChart() {
		if (dataBarChart == null || dataBarChart.trim().length() <= 0) {
			populateBarData();
			}
		return dataBarChart;
	}
	private void populateBarData() {
		StringBuilder stringBuilder = new StringBuilder();
		List <String> listaDeEstados=new ArrayList<String>();
		listaDeEstados.add("En espera de revision");
		listaDeEstados.add("En revision");
		listaDeEstados.add("Proyecto");
		listaDeEstados.add("Solucionado");
		try {
			for (String Estado : listaDeEstados) {
				stringBuilder.append("[");
				stringBuilder.append("'");
				stringBuilder.append(Estado);
				stringBuilder.append("'");
				stringBuilder.append(",");
				stringBuilder.append(Integer.toString(service.consultarIniciativasPorEstado(Estado).size()));
				stringBuilder.append("]");
				stringBuilder.append(",");
			}
			dataBarChart= stringBuilder.toString().substring(0,
			stringBuilder.toString().length() - 1);
		} catch (ExcepcionServicesIniciativa e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setDataBarChart(String dataBarChart) {
		this.dataBarChart = dataBarChart;
	}
	public String getDataChart() {
		if (dataChart == null || dataChart.trim().length() <= 0) {
			populateData();
			}
		return dataChart;
	}
	public void setDataChart(String dataChart) {
		this.dataChart = dataChart;
	}
	private void populateData() {
		StringBuilder stringBuilder = new StringBuilder();
		List<String> listaDeAreas= new ArrayList<String>();
		Map <String, Integer> dic= new HashMap<String,Integer>();
		try {
			for(Iniciativa ini : service.consultarIniciativas()) {
				String area=ini.getCreador().getArea();
				if(dic.containsKey(area)) {
					dic.put(area, dic.get(area)+1);
				}else {
					dic.put(area, 1);
				}
			}
		} catch (ExcepcionServicesIniciativa e) {
			e.printStackTrace();
		}
		listaDeAreas.addAll(dic.keySet());
		for (String Area : listaDeAreas) {
			stringBuilder.append("[");
			stringBuilder.append("'");
			stringBuilder.append(Area);
			stringBuilder.append("'");
			stringBuilder.append(",");
			stringBuilder.append(Integer.toString(dic.get(Area)));
			stringBuilder.append("]");
			stringBuilder.append(",");
		}
		dataChart= stringBuilder.toString().substring(0,
		stringBuilder.toString().length() - 1);
	}
	
}

