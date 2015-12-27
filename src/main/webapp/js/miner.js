/**
 * Created by Issen on 27.12.2015.
 */
$(document).ready(function(){
    $('#step-select').change(function(e){
        var select = $(this);
        var stepKey = select.val();
        var url = '/steps/getStepConfigurationTemplate';
        var data = "view_type=create&step_key=" + stepKey;

        $.ajax({ url: url, data: data, type:"GET",
            success: function(data) {
                    $("#step_configuration").html(data);
            },
            error: function(xhr, status, errorThrown) {
                    alert(xhr.status + xhr.responseText );
            }
        });
    });
})
