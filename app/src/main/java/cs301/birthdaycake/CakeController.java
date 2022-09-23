package cs301.birthdaycake;

import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CakeController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener{

	private CakeView cakeView;
	private CakeModel cakeModel;
	private Button litButton;

	public CakeController(CakeView cake)
	{
		cakeView = cake;
		cakeModel = cakeView.getCakeModel();
	}

	@Override
	public void onClick(View view) {
		cakeModel.lit = !cakeModel.lit;
		litButton = (Button)view;
		if (cakeModel.lit)
		{
			litButton.setText("Blow out");
		} else
		{
			litButton.setText("Re-light");
		}
		cakeView.invalidate();
	}

	@Override
	public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
		switch(compoundButton.getId()) {
			case R.id.swcCandles:
				cakeModel.candleToggle = !cakeModel.candleToggle;
				break;
			case R.id.swcFrosting:
				cakeModel.frosting = !cakeModel.frosting;
				break;
		}
		cakeView.invalidate();
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		cakeModel.candles = progress;
		cakeView.invalidate();
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {

	}

}
