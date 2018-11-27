package PROYPDSW.view;
import org.primefaces.model.chart.PieChartModel;
import com.google.inject.Inject;
import PROYPDSW.samples.services.ExcepcionServicesIniciativa;
import PROYPDSW.samples.services.ServicesIniciativa;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@SuppressWarnings("deprecation")
@ManagedBean (name="estadisticasBean")
public class EstadisticasBean extends BasePageBean{
	@Inject
	private ServicesIniciativa service;
	private PieChartModel model;

	public void iniciar() {
		model = new PieChartModel();
		
        model.set("Brand 1", 5);
        model.set("Brand 2", 3);
        model.set("Brand 3", 7);
        model.set("Brand 4", 4);
        model.setLegendPosition("w");
	}
	
	  public PieChartModel getModel() {
	      return model;
	  }
}

