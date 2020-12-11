package com.focusstart.android.finalproject.loanmoneyonline.core.di.app.module

import androidx.work.WorkerFactory
import com.focusstart.android.finalproject.loanmoneyonline.core.di.app.scope.ApplicationScope
import com.focusstart.android.finalproject.loanmoneyonline.core.workManager.CustomWorkerFactory
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.datasource.LoanDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.db.AppDatabase
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.db.LoansDao
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.network.api.ILoanApi
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.repository.LoanRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.useCase.GetListOfLoansFromNetworkUseCase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class WorkerModule {
    @Provides
    @ApplicationScope
    fun provideWorkerFactory(getListOfLoansFromNetworkUseCase: GetListOfLoansFromNetworkUseCase): WorkerFactory =
        CustomWorkerFactory(getListOfLoansFromNetworkUseCase)

    @Provides
    @ApplicationScope
    fun provideGetListOfLoansUseCase(loanRepositoryImpl: LoanRepositoryImpl): GetListOfLoansFromNetworkUseCase =
        GetListOfLoansFromNetworkUseCase(loanRepositoryImpl)

    @Provides
    @ApplicationScope
    fun provideLoanRepository(
        loanDataSourceImpl: LoanDataSourceImpl,
    ): LoanRepositoryImpl =
        LoanRepositoryImpl(loanDataSourceImpl)

    @Provides
    @ApplicationScope
    fun provideLoanSource(apiService: ILoanApi, dao: LoansDao): LoanDataSourceImpl =
        LoanDataSourceImpl(apiService, dao)

    @Provides
    @ApplicationScope
    fun provideLoanApiClass(retrofit: Retrofit): ILoanApi = retrofit.create(ILoanApi::class.java)

    @Provides
    @ApplicationScope
    fun provideLoansDao(appDatabase: AppDatabase) = appDatabase.loansDao()
}