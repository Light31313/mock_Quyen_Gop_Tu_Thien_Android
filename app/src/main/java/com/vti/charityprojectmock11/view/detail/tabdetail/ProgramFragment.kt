package com.vti.charityprojectmock11.view.detail.tabdetail

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.vti.charityprojectmock11.view.detail.tabdetail.adapter.ViewPager2Adapter
import com.vti.charityprojectmock11.databinding.FragmentProgramBinding
import com.vti.charityprojectmock11.model.DonateProgram
import com.vti.charityprojectmock11.viewmodel.detail.DetailDonateViewModel


class ProgramFragment : Fragment() {

    private val viewModel: DetailDonateViewModel by viewModels(ownerProducer = { requireParentFragment() })
    private lateinit var binding: FragmentProgramBinding

    private val imageList = mutableListOf<String>()
    private var currentIndex: Int = 0

    private lateinit var mHandler: Handler
    private lateinit var mRunnable: Runnable

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProgramBinding.inflate(inflater, container, false)

        binding.vpProgramImg.adapter = ViewPager2Adapter(imageList, requireContext())
        binding.vpProgramImg.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.indicatorProgam.setViewPager(binding.vpProgramImg)
        //auto slide image
        mHandler = Handler()
        mRunnable = Runnable {
            if ((currentIndex + 1) > imageList.size) {
                currentIndex = 0;
            } else {
                currentIndex++;
            }
            binding.vpProgramImg.setCurrentItem(currentIndex);
            mHandler.postDelayed(
                mRunnable, // Runnable
                3 * 1000 // Delay in milliseconds
            )
        }
        // Schedule the task to repeat after 3 second
        mHandler.postDelayed(
            mRunnable, // Runnable
            3 * 1000 // Delay in milliseconds
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (viewModel.donateProgram != null) {
            viewModel.donateProgram.observe(viewLifecycleOwner, { donateProgram ->
                putToList(donateProgram)
                binding.tvContent.text = donateProgram.content
                binding.tvTitle.text = donateProgram.name
                binding.tvProcess.text =
                    donateProgram.currentMoney.toString() + "/" + donateProgram.targetMoney.toString()
                if (donateProgram.currentMoney!! < donateProgram.targetMoney!!) {
                    binding.pbProgramProcess.progress =
                        (donateProgram.currentMoney!!.div(donateProgram.targetMoney!!)
                            .times(100)).toInt()
                } else {
                    binding.pbProgramProcess.progress = 100
                }

                binding.tvCurrentDonationAmount.text =
                    (donateProgram.currentMoney!!.div(donateProgram.targetMoney!!)
                        .times(100)).toInt().toString() + "%"
//                if (Calendar.getInstance().time.after(donateProgram.endDate)) {
//                    binding.tvExpireTime.text = "Đã kết thúc"
//                } else {
//                    var diff: Long = donateProgram.endDate!!.time - Calendar.getInstance().time.time
//                    binding.tvExpireTime.text =
//                        TimeUnit.MICROSECONDS.toDays(diff).toString() + " ngày"
//                }
            })
        }
        if (viewModel.donate != null) {
            viewModel.donate.observe(viewLifecycleOwner, { donate ->
                binding.tvDonationAmount.text = donate.size.toString()
            })
        }
    }

    private fun putToList(donateProgram: DonateProgram) {
        //call api get image
        imageList.add(donateProgram.mainImage.toString())
        //imageList.add(donateProgram.subImage1.toString())
        //imageList.add(donateProgram.subImage2.toString())
        //imageList.add(donateProgram.subImage3.toString())

//        imageList.add(R.drawable.ic_baseline_arrow_back_ios_24)
//        imageList.add(R.drawable.ic_notifications_black_24dp)
//        imageList.add(R.drawable.ic_dashboard_black_24dp)
//        imageList.add(R.drawable.ic_home_black_24dp)

    }
}