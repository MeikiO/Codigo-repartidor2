public class DMS {
		double degree;
		double min;
		double seg;
		
		public DMS(double latitud) {
			this.decimalToDMS(latitud);	
		}
		/**
		 * Given a decimal longitudinal coordinate such as <i>-79.982195</i> it will
		 * be necessary to know whether it is a latitudinal or longitudinal
		 * coordinate in order to fully convert it.
		 * 
		 * @param latitud
		 *            coordinate in decimal format
		 * @return coordinate in DMS format
		 * @see <a href='https://goo.gl/pWVp60'>Geographic coordinate conversion
		 *      (wikipedia)</a>
		 */
		
		private void decimalToDMS(double latitud) {

			double mod = latitud % 1;
			double intPart = latitud;
		
			this.degree = Math.abs(intPart);
			//this.degree=this.redondearA2Decimales(this.degree);

			latitud = mod * 60;
			mod = latitud % 1;
			intPart = latitud;
			if (intPart < 0)
				intPart *= -1;

			this.min = intPart;
			//this.min=this.redondearA2Decimales(this.min);

			latitud = mod * 60;
			intPart = latitud;
			if (intPart < 0)
				intPart *= -1;

			this.seg = intPart;
			//this.seg=this.redondearA2Decimales(this.seg);

		}
		
		//https://www.it-swarm-es.com/es/java/como-mostrar-una-salida-de-datos-flotantes-con-2-decimales-en-java/968241099/
		
		public double redondearA2Decimales(double degree2) {
			return (Math.round(degree2*100) / 100.0);
		}
		
		
		public double getDegree() {
			return degree;
		}
		public void setDegree(double degree) {
			this.degree = degree;
		}
		public double getMin() {
			return min;
		}
		public void setMin(double min) {
			this.min = min;
		}
		public double getSeg() {
			return seg;
		}
		public void setSeg(double seg) {
			this.seg = seg;
		}
		
		@Override
		public String toString() {
			return this.degree + "°" + this.min + "'" + this.seg + "\"";
		}


		
		
		
}