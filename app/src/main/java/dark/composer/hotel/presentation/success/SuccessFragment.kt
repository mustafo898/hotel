package dark.composer.hotel.presentation.success

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import dark.composer.hotel.R
import dark.composer.hotel.common.BaseFragment
import dark.composer.hotel.databinding.FragmentSuccessBinding

class SuccessFragment : BaseFragment<FragmentSuccessBinding>(FragmentSuccessBinding::inflate) {
    override fun onViewCreate(savedInstanceState: Bundle?) {
        binding.back.setOnClickListener {
            navController.popBackStack()
        }

        binding.next.setOnClickListener {
            navController.navigate(R.id.action_successFragment_to_mainFragment)
//            for (i in 0 until navController) {
//                navController.popBackStack()
//            }
            clearBackStack(requireActivity().supportFragmentManager)
        }
    }

    private fun clearBackStack(fragmentManager: FragmentManager) {
        if (fragmentManager.backStackEntryCount > 0) {
            val entry: FragmentManager.BackStackEntry = fragmentManager.getBackStackEntryAt(0)
            fragmentManager.popBackStack(entry.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }
}