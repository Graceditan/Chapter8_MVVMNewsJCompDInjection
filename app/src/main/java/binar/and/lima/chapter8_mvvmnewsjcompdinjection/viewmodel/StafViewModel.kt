import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import binar.and.lima.chapter8_mvvmnewsjcompdinjection.NewsRepository
import binar.and.lima.chapter8_mvvmnewsjcompdinjection.StafRepository
import binar.and.lima.chapter8_mvvmnewsjcompdinjection.data.ResponseNewsItem
import binar.and.lima.chapter8_mvvmnewsjcompdinjection.data.ResponseStafItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StafViewModel @Inject constructor(private val api : StafRepository) : ViewModel() {

    private val stafState = MutableStateFlow(emptyList<ResponseStafItem>())

    val dataState : StateFlow<List<ResponseStafItem>>
        get() = stafState


    init {
        viewModelScope.launch {
            val staff = api.getStaf()
            stafState.value = staff
        }
    }

}